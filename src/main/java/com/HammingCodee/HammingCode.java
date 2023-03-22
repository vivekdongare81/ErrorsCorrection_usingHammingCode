package com.HammingCodee;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


/**
 * Servlet implementation class HammingCode
 */
@WebServlet("/homeServelet")
public class HammingCode extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HammingCode() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.sendRedirect("home.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		String input = request.getParameter("input");
	    String errorStr =  request.getParameter("errorStr");
	    String[] version =  request.getParameterValues("version");
	  

 
		try { 
			  String subVal = request.getParameter("submit");
			  
			if(subVal.equals("encode")) {
				for(int i=0;i<version.length;i++) {
					
					HammingLogic hc = new HammingLogic();
					
					hc =  hc.mainnEncode(input,version[i]);
					
					out.println("# Version ("+version[i]+ ") <br/> ");
					
					out.println("<br /> * Encoding Result<br/> ");
					out.println("<div> Input - "+ hc.input );
					out.println("<br/> Count of Blocks - "+ hc.countDiv );
					out.println("<br/> Count of Parity bits - "+  hc.parityCount);
					out.println("<br /> Coderate - "+  hc.codeRate);
					out.println("<br /> Time taken to Encode - "+  hc.timeTakenToEncode+" ms ");
					out.println("<br /> Encoded bitstream - "+  hc.encoded);
					out.println("<br />  ");
				}
			}else {

				for(int i=0;i<version.length;i++) {
					
				
				HammingLogic hc = new HammingLogic();
				
				hc =  hc.mainnDecode(errorStr,version[i]);
				
				out.println(" ");
				out.println("<br /> * Decoding Result <br/> ");
				out.println("Corrupt Code - "+  errorStr);
				out.println("<br /> Corrected Code - "+  hc.correctedEncode);
				out.println("<br /> No of Errors - "+  hc.errCount);
				out.println("<br /> Time taken to Decode - "+  hc.timeTakenToDecode+" ms ");
				out.println("<br /> Original Input - "+  hc.output);
				out.println("<br /> ");
				out.println("<br /> ");
			}
			
		}
			
		} catch (Exception e) {

		}
	}

}
