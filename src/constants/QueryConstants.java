package constants;

public class QueryConstants 
{
	public static String insertcl="insert into calld values(?,?,?,?,?,?,?)";
	public static String updatecl="update calld set DURATION=?,CALLTYPE=?,DIALNO=? where CALLID=?";
	public static String deletecl="DELETE FROM calld WHERE CALLID=?";
	public static String viewcl="SELECT * FROM calld";
	public static String viewcl1="select * from calld where CALLID=?";
	
}
