package cs5412.project.distributed_file_system.dao.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.inject.Inject;
import javax.inject.Named;
import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import cs5412.project.distributed_file_system.dao.HistoryDAO;
import cs5412.project.distributed_file_system.pojo.History;

@Named
public class HistoryJdbcDAO implements HistoryDAO {
	
	@Inject
	private JdbcTemplate jdbcTemplate;

	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	private static final class HistoryMapper implements RowMapper<History> {
		public History mapRow(ResultSet rs, int rowNum) throws SQLException {
			History history = new History();
			history.setHid(rs.getInt("hid"));
			history.setTs(rs.getTimestamp("timestamp"));
			history.setUid(rs.getInt("uid"));
			history.setOldFid(rs.getInt("File_fid_old"));
			history.setNewFid(rs.getInt("File_fid_new"));
			history.setOperationType(rs.getInt("type"));
			return history;
		}
	}

	@Override
	public History getHistoryByHid(int hid) {
		History ret = (History) this.jdbcTemplate
				.queryForObject(
						"select hid, timestamp, uid, File_fid_old, File_fid_new, type from History where hid = ?",
						new Object[] { hid }, new HistoryMapper());
		return ret;
	}

	@Override
	public int createHistory(History history) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean updateHistory(History history) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteHisotry(History history) {
		// TODO Auto-generated method stub
		return false;
	}

}