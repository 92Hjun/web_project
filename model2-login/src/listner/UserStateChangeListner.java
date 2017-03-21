package listner;

import java.sql.SQLException;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import dao.UserDAO;
import vo.UserVO;

public class UserStateChangeListner implements HttpSessionListener{

	@Override
	public void sessionCreated(HttpSessionEvent arg0) {
		
		
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent event) {
		HttpSession session = event.getSession();
		
		UserVO user = (UserVO)session.getAttribute("LOGINED_USER");
		if (user != null) {
			String userId = user.getId();
			UserDAO dao = new UserDAO();
			try {
				dao.changeUserStateN(userId);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}
	
}
