package in.mindcraft.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import in.mindcraft.pojos.Laptop;
import in.mindcraft.utils.DBUtils;

public class LaptopDao {
	
	private Connection cn;
	private PreparedStatement pst1;
	private PreparedStatement pst2;
	
	public void addLaptop(Laptop laptop) throws SQLException, ClassNotFoundException {
		cn=DBUtils.openConnection();
		pst1=cn.prepareStatement("insert into laptop values(?,?,?)");
		pst1.setInt(1,laptop.getLid());
		pst1.setString(2,laptop.getMake());
		pst1.setDouble(3,laptop.getCost());
		pst1.execute();
//		cn.commit();
		DBUtils.closeConnection();
	}
	
	public List<Laptop> getLaptops() throws SQLException, ClassNotFoundException{
		cn=DBUtils.openConnection();
		List <Laptop> list=new ArrayList<Laptop>();
		pst2=cn.prepareStatement("select * from laptop");
		ResultSet rs=pst2.executeQuery();
		while(rs.next()) {
			list.add(new Laptop(rs.getInt(1),rs.getString(2),rs.getDouble(3)));
		}
		DBUtils.closeConnection();
		return list;
	}
}
