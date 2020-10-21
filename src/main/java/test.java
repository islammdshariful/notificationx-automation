
public class test {

	public static void main(String[] args) {
		String url = "http://devmode.local/wp-admin/post.php?post=4159&action=edit";
		String[] arrOfStr = url.split("=", -2);
		String pd_link = arrOfStr[1];
		String[] get_id = pd_link.split("&");
		String pd_id = get_id[0];
		System.out.println(pd_id);
		

	}

}
