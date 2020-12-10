import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class test {

	public static void main(String[] args) {
//		String url = "http://devmode.local/wp-admin/post.php?post=4159&action=edit";
//		String[] arrOfStr = url.split("=", -2);
//		String pd_link = arrOfStr[1];
//		String[] get_id = pd_link.split("&");
//		String pd_id = get_id[0];
//		System.out.println(pd_id);
//		
//		Date date = Calendar.getInstance().getTime();
//		String comment_text = "A usefull feature indeed." + date ;
		
//		Date date = new Date();
//		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
//		System.out.println(sdf.format(date));	
		
//		String a = "$20";
//		String s = a.replace("$", "");
//		int price = Integer.parseInt(s);
//		System.out.println(price+10);
		
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
		String name = "subs"+ sdf.format(date);
		String username = name.replace(":", "");
		System.out.println(username);
	}

}
