package com.example;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/GenerateKey")
public class GenerateKeyServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        // Get form data
        String fname = req.getParameter("firstname");
        String lname = req.getParameter("lastname");

        // Extract first 2 characters of each
        String fpart = fname.length() >= 2 ? fname.substring(0, 2) : fname;
        String lpart = lname.length() >= 2 ? lname.substring(0, 2) : lname;

        // Create the key
        String key = fpart.toUpperCase() + lpart.toUpperCase();

        // Show the result
        res.setContentType("text/html");
        try (PrintWriter out = res.getWriter()) {
            out.println("<!DOCTYPE html><html><head><title>Generated Key</title></head><body>");
            out.printf("<h2>Hello %s %s!</h2>", fname, lname);
            out.printf("<h3>Your generated key is: <code>%s</code></h3>", key);
            out.println("<p><a href=\"index.html\">Go Back</a></p>");
            out.println("</body></html>");
        }
    }
}
