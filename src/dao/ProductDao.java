package dao;

import static db.JdbcUtil.*;
import java.util.*;
import javax.sql.*;
import java.sql.*;
import vo.*;

public class ProductDao {
	private static ProductDao productDao;
	private Connection conn;

	private ProductDao() {
	}

	public static ProductDao getInstance() {
		// 싱글톤 방식으로 인스턴스 낭비를 줄임
		if (productDao == null)
			productDao = new ProductDao();
		return productDao;
	}

	public void setConnection(Connection conn) {
		this.conn = conn;
	}

	public ArrayList<ProductInfo> getPdtInfo() {
		Statement stmt = null;
		ResultSet rs = null;
		ArrayList<ProductInfo> pdtList = new ArrayList<ProductInfo>();
		ProductInfo pdt = null;
		String sql = "";

		try {
			sql = "select * from TBL_PRODUCT";
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				pdt = new ProductInfo();
				pdt.setPi_id(rs.getString("pi_id"));
				pdt.setPi_name(rs.getString("pi_name"));
				pdt.setPi_cost(rs.getInt("pi_cost"));
				pdt.setPi_img(rs.getString("pi_img"));
				pdtList.add(pdt);
				// 하나의 상품 정보를 담은 인스턴스 pdt를 pdtList에 저장
			}

		} catch (Exception e) {
			System.out.println("ProductDao 클래스의 getPdtInfo() 메소드 오류");
			e.printStackTrace();
		}
		return pdtList;
	}

}
