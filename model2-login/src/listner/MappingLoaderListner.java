package listner;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import model2.Controller;

public class MappingLoaderListner implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent event) {
		System.out.println("서버가 꺼지고 사라질때 contextDestroyed....");
	}

	@Override
	public void contextInitialized(ServletContextEvent event) {
		ServletContext application = event.getServletContext();
		
		try {
			Map<String, Controller> controllers = new HashMap<>();
			Properties prop = new Properties();
			prop.load(this.getClass().getResourceAsStream("../config/mapping.properties"));
			Set<Object> keys = prop.keySet();
			
			for (Object key : keys) {
				String className = prop.getProperty((String)key);
				Controller controller = (Controller) Class.forName(className).newInstance();
				
				controllers.put((String)key, controller);
				
			}
			
			application.setAttribute("controllersMap", controllers);
			
			
		} catch (IOException e) {
			throw new RuntimeException(e);
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		} catch (IllegalAccessException e) {
			throw new RuntimeException(e);
		} catch (InstantiationException e) {
			throw new RuntimeException(e);
		}
		
	}
	
	
}
