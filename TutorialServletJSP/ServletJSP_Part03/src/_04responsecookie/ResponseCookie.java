package _04responsecookie;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/RespCookieDeneme")
public class ResponseCookie extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		PrintWriter pw = resp.getWriter();
		// Cookie ekleme:
		Cookie kAdi = new Cookie("username", "vayorebl");
		Cookie sifre = new Cookie("password", "272727");
		// kAdi.setMaxAge(5); // uygularsam 5 sn sonra cookie kaybolur.
		// (RequestHeader'dan da siliniyor. Response Header'da kalıyor.)
		resp.addCookie(kAdi);
		resp.addCookie(sifre);

		// Cookie erisme: req ile okudum, dikkaayt!
		Cookie[] cookies = req.getCookies();
		if (cookies != null) {
			for (Cookie c : cookies) {
				pw.print(c.getName() + " " + c.getValue());
			}
		}

	}
}
