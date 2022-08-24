package utils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import model.*;
import utils.HibernateConnection;
import utils.ConnectionDB;


public class Manager {

	public Manager() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Student getStuid(String Id){
		ConnectionDB condb = new ConnectionDB();
		Connection con = condb.getConnection();
		Student stu = null;
		try {
			String sql = "select * from student where idstudent = " + Id;
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				stu = new Student(rs.getString(1), rs.getString(2), rs.getString(3));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return stu;
	}
	
	public List<Student> searchStu(String name){
		List<Student> list = new ArrayList<>();
		ConnectionDB condb = new ConnectionDB();
		Connection con = condb.getConnection();
		PreparedStatement stmt = null;
		try {
			String sql = "select * from student where studentname like '%" + name +"%' order by idstudent";
			stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				list.add(new Student(rs.getString(1), rs.getString(2), rs.getString(3)));	
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}
	
	public int Add(Student addid){
		ConnectionDB condb = new ConnectionDB();
		Connection con = condb.getConnection();
		PreparedStatement stmt = null;
		try {
			String sql = "insert into student value('"+addid.getIdstudent()+"','"+addid.getStudentname()+"','"+addid.getTell()+"')";
			stmt = con.prepareStatement(sql);
			int results = stmt.executeUpdate();
			con.close();
			return results;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return 0;
	}
	
	public int Delete(String Id){
		ConnectionDB condb = new ConnectionDB();
		Connection con = condb.getConnection();
		PreparedStatement stmt = null;
		try {
			String sql = "Delete from student where idstudent = " + Id;
			stmt = con.prepareStatement(sql);
			int results = stmt.executeUpdate();
			con.close();
			return results;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return 0;
	}
	
	public int Edit(Student id){
		int result = 0;
		ConnectionDB condb = new ConnectionDB();
		Connection con = condb.getConnection();
		
		try {
			Statement stmt = con.createStatement();
			String sql = "Update student set studentname = '"+id.getStudentname()+"',tell = '"+id.getTell()+"' where idstudent = '"+id.getIdstudent()+"'";
			result = stmt.executeUpdate(sql);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	public int EditSP(Student id){
		int result = 0;
		ConnectionDB condb = new ConnectionDB();
		Connection con = condb.getConnection();
		
		try {
			java.sql.CallableStatement cs  = con.prepareCall("{call edit(?,?,?)}");
			cs.setString(1, id.getIdstudent());
			cs.setString(2, id.getStudentname());	
			cs.setString(3, id.getTell());	
			result = cs.getUpdateCount();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	public String doLogin(Logins login) {
		ConnectionDB condb = new ConnectionDB();
		Connection con = condb.getConnection();
		Statement stmt = null;
		String result="";
		
		try {
			stmt = con.createStatement();
			String sql = "select name,pass from logins where name= '"+login.getName() + "'";
			
			ResultSet rs = stmt.executeQuery(sql);
			
			if(rs.next()) {
				String password = rs.getString(2);
				
				if(login.getPass().equals(password)) {
					result = "เข้าสู่ระบบเสร็จสิ้น";
				}else {
					result = "เกิดข้อผิดพลาดในการเข้าสู่ระบบ";
				}	
			}else {
				result = "username ไม่ตรงกัน";
			}
			rs.close();
			stmt.close();
			con.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;

	}
	
	public String do_login_process(Logins login) { 
		 ConnectionDB dbcon = new ConnectionDB(); 
		 Connection conn = dbcon.getConnection(); 
		 Statement stmt = null; 
		 ResultSet rs = null; 
		 try{ 
		 String sql = "select count(name) from logins where name = '"+login.getName()+"' and pass = '"+login.getPass() + "'"; 
		 stmt = conn.createStatement(); 
		 rs = stmt.executeQuery(sql); 
		 int count = 0; 
		 if (rs.next()){ 
			 count = rs.getInt(1); 
		 } 
		 if (count == 1) { 
			 return "login success"; 
		 }else { 
			 return "username or password does't match"; 
		 } 
		 }catch(Exception ex){ 
			 return "Login error, please try again!!"; 
		 }finally{ 
		 try { 
		 rs.close(); 
		 stmt.close(); 
		 conn.close(); 
		 } catch (SQLException e) { 
			 e.printStackTrace(); 
		 } 
		 } 
		 } 

		public String doSignUp(Logins login) { 
		 try{ 
			 ConnectionDB dbcon = new ConnectionDB(); 
			 Connection conn = dbcon.getConnection(); 
			 Statement statment = conn.createStatement(); 
		 
		     statment.execute("insert into logins values('" +login.getName()+"','"
		     +login.getPass()+ "','" 
		     +login.getFullname() + "','" 
		     +login.getGender()+"','"
		     +login.getImage()+"')"); 	 
		 conn.close();
		 	return "Register Successfully..."; 
		 }catch(Exception e){ 
			 System.out.println(e); 
			 return "Something went wrong please try again!!!"; 
		 } 
		 }
		
		public Logins Log(Logins log) {
	        Logins lb = null;
	        ConnectionDB dbcon = new ConnectionDB(); 
	        Connection con = dbcon.getConnection();
	        try {
	            Statement stmt = con.createStatement();
	            String sql = "select * from logins where name = '" + log.getName() +
	                            "' and pass = '" + log.getPass() + "'";
	            ResultSet rs = stmt.executeQuery(sql);
	            if (rs.next() && rs.getRow() == 1  ) {
	                String uname = rs.getString(1);
	                String pass = rs.getString(2);
	                String name = rs.getString(3);
	                String gender = rs.getString(4);
	                String img = rs.getString(5);
	                lb = new Logins(uname, pass, name, gender, img);
	            }
	            con.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }

	        return lb;
	    }
		
		public List<Logins> getloginss(String id) {
           List<Logins> list = new ArrayList<>();
           ConnectionDB condb = new ConnectionDB();
           Connection con = condb.getConnection();
           try {
               Statement stmt = con.createStatement();
               String sql = "select * from logins where name = '"+ id +"'";
               ResultSet rs = stmt.executeQuery(sql);
               while (rs.next()) {
                   String username = rs.getString(1);
                   String password = rs.getString(2);
                   String fullname = rs.getString(3);
                   String gender = rs.getString(4);
                   String image = rs.getString(5);
                   Logins s = new Logins(username, password, fullname, gender, image);
                   list.add(s);
               }
               con.close();
           } catch (SQLException e) {
               e.printStackTrace();
           }

           return list;
       }
		
		public int AddMenu(Menu mn) {
			ConnectionDB condb = new ConnectionDB();
			Connection con = condb.getConnection();
			PreparedStatement stmt = null;
			int result = 1;
			try {
				String sql = "insert into menu value ("+ mn.getMenuid() + ",'"+mn.getMenuName()+"',"+mn.getPrice()+",'"+mn.getCategory().getCategoryid()+"','"+mn.getImage()+"')";
				stmt = con.prepareStatement(sql);
				result = stmt.executeUpdate();
					
			}catch(SQLException e) {
				result = 0;
				e.printStackTrace();
			}
			return result;
		}
		
		public List<Category> getCategory(){
			
			ConnectionDB condb = new ConnectionDB();
			Connection con = condb.getConnection();
			PreparedStatement stmt = null;
			List<Category> result = new ArrayList<>();
			
			try {
				String sql = "select idcategory , categoryname from category";
				stmt = con.prepareStatement(sql);
				ResultSet rs = stmt.executeQuery();
				System.out.println(rs);
				
				
				while(rs.next()) {
					result.add(new Category(rs.getInt(1),rs.getString(2)));
					
				}
				
				rs.close();
				stmt.close();
				con.close();
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			return result;

		}
		
		public List<Menu> getMenus(){
			
			ConnectionDB condb = new ConnectionDB();
			Connection con = condb.getConnection();
			PreparedStatement stmt = null;
			List<Menu> result = new ArrayList<>();
			Category c = new Category();
			try {
				String sql = "select * from menu ";
				stmt = con.prepareStatement(sql);
				ResultSet rs = stmt.executeQuery();
				System.out.println(rs);
				
				while(rs.next()) {
					int id = rs.getInt(1);
					String name =rs.getString(2);
					int price =rs.getInt(3);
					String img =rs.getString(4);
					Object ct = c.getCategoryid();
					
					result.add(new Menu(id,name,price,c,img));

					
				}
				rs.close();
				stmt.close();
				con.close();
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			return result;

		}
		
		public int getMaxIdMenu() {
			ConnectionDB condb = new ConnectionDB();
			Connection con = condb.getConnection();
			PreparedStatement stmt = null;
			int result = 0;
			try {
				String sql = "Select Max(ID) from menu";
				stmt = con.prepareStatement(sql);
				ResultSet rs = 	stmt.executeQuery();
				while (rs.next()) {
					result = rs.getInt(1);
				}
			}catch(SQLException e) {
				e.printStackTrace();
			}
			return result;
		}
		
		public List<Category> getCategoryList() {
			ConnectionDB condb = new ConnectionDB();
			Connection con = condb.getConnection();
			PreparedStatement stmt = null;
			List<Category> result = new Vector<Category>();
			try {
				String sql = "Select * from category ";
				stmt = con.prepareStatement(sql);
				ResultSet rs = 	stmt.executeQuery();
				while (rs.next()) {
					int id = rs.getInt(1);
					String name = rs.getString(2);
					result.add(new Category(id,name));
				}
			}catch(SQLException e) {
				e.printStackTrace();
			}
			return result;
		}
		

		
		public int editMenu(Menu mn) {
			int result = 1;
			ConnectionDB condb = new ConnectionDB();
			Connection con = condb.getConnection();
			
			try {
				CallableStatement stmt = con.prepareCall("{call editmenu(?,?,?,?,?)}");
				stmt.setInt(1, mn.getMenuid());
				stmt.setString(2, mn.getMenuName());
				stmt.setInt(3, mn.getPrice());
				stmt.setInt(4, mn.getCategory().getCategoryid());
				stmt.setString(5, mn.getImage());
				stmt.execute();
				
				result = stmt.getUpdateCount();
				con.close();
			}catch(Exception e) {
				result = 0;
				e.printStackTrace();
			}
			return result;
		}
		
		public int deletemenu(int idmenu) {
			ConnectionDB condb = new ConnectionDB();
			Connection con = condb.getConnection();
			PreparedStatement stmt = null;
			int result = 0;
			try {
				String sql = "Delete from menu where ID = "+idmenu+"";
				stmt = con.prepareStatement(sql);
				result = 	stmt.executeUpdate();

			}catch(SQLException e) {
				e.printStackTrace();
			}
			return result;
		}
		
		public int deletemenuSP(int idmenu) {
			ConnectionDB condb = new ConnectionDB();
			Connection con = condb.getConnection();

			int result = 0;
			try {
				CallableStatement stmt = con.prepareCall("{call delete(?)}");
				stmt.setInt(1, idmenu);
				result = 	stmt.executeUpdate();

			}catch(SQLException e) {
				e.printStackTrace();
			}
			return result;
		}
		public int insertLogins(Logins l){
			
			try {
			SessionFactory sessionFactory = HibernateConnection.doHibernateConnection();
			Session session = sessionFactory.openSession();
		
			Transaction t = session.beginTransaction();
			
			session.save(l);
			t.commit();
			session.close();
			return 1;
			}catch(Exception e) {
				
				return 0;
			}
		}
		public Menu getmenuid(int Id){
			ConnectionDB condb = new ConnectionDB();
			Connection con = condb.getConnection();
			Menu menus = null;
			Category c = new Category();
			try {
				String sql = "select * from menu where ID = " + Id+"";
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(sql);
				
				while(rs.next()) {
					menus = new Menu(rs.getInt(1), rs.getString(2), rs.getInt(3),c,rs.getString(5));
					
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return menus;
		}
		
		public List<Menu> getlistmenuid(int Id){
			List<Menu> list = new ArrayList<>();
			ConnectionDB condb = new ConnectionDB();
			Connection con = condb.getConnection();
			Category c = null;
			try {
				String sql = "select * from menu where ID = " + Id+"";
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(sql);
				
				while(rs.next()) {
					int id = rs.getInt(1);
					String name = rs.getNString(2);
					int price = rs.getInt(3);
					Object ct = rs.getInt(4);
					String img = rs.getString(5);
					Menu menus = new Menu(id,name,price,c,img);
					list.add(menus);
					
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return list;
		}
		
		public List<Menu> searchMenu(String name){
			List<Menu> list = new ArrayList<>();
			ConnectionDB condb = new ConnectionDB();
			Connection con = condb.getConnection();
			PreparedStatement stmt = null;
			try {
				String sql = "select * from menu where name like '%" + name +"%' order by ID";
				stmt = con.prepareStatement(sql);
				ResultSet rs = stmt.executeQuery();
				while(rs.next()) {
					list.add(new Menu(rs.getInt(1), rs.getString(2), rs.getInt(3), null, rs.getString(5)));	
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return list;
		}
}
