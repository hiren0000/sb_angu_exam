package com.rebel.ExamPortalSb.Angular.config;

import com.rebel.ExamPortalSb.Angular.payloads.JwtUtil;
import com.rebel.ExamPortalSb.Angular.util.CustomerUserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class JwtAuthenticatonFilter extends OncePerRequestFilter
{

    @Autowired
    private CustomerUserDetailService customerUserDetailService;

    @Autowired
    private JwtUtil jwtUtil;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException
    {

        // Header
        final String requestTokenHeader = request.getHeader("Authorization");
        System.out.println(requestTokenHeader);

        String username = null;
        String jwtToken = null;

        // Token Part -1
        if(requestTokenHeader != null && requestTokenHeader.startsWith("Bearer "))
        {
            //condition-true
            try
            {
                jwtToken = requestTokenHeader.substring(7);

                username = this.jwtUtil.extractUsername(jwtToken);
            }
            catch (Exception e)
            {
                e.printStackTrace();
                System.out.println("something wrong with with Token part -1   ");
            }

        }
        else
        {
            System.out.println("Invalid token, or might not start with Bearer string");
        }

        //------------------------------------------------------------------------------------------------------

        //Validating Token (Token part -2 )
        if(username != null && SecurityContextHolder.getContext().getAuthentication() == null)
        {
            final UserDetails userDetails = this.customerUserDetailService.loadUserByUsername(username);

            if(this.jwtUtil.validateToken(jwtToken, userDetails))
            {
                //after validating token

                UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken
                        = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());

                usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));



                SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
            }

        }
        else
        {
            System.out.println("Token is not valid !! ");
        }

        filterChain.doFilter(request,response);

    }
}
