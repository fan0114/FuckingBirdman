package cs5412.project.distributed_file_system.dao;

import java.util.List;

import cs5412.project.distributed_file_system.pojo.File;

public interface FileDAO {
	public int createFile(File file);
	public boolean updateFile(File file);
	public File getFileByFid(int fid);
	public List<File> getFileByParentDir(File parentDir);
	public boolean deleteFile(File file);
	public File getRootDirForUser(int userId);
	public boolean createHistory(int uid, int fidold, int fidnew, int type);
	public boolean isFilePublic(int fid);
}
