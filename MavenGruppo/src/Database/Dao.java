package Database;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;
import java.util.Optional;

public interface Dao<T, ID> {
	
Optional<T> find(ID id) throws SQLException;
 T findIdForJson(ID id) throws SQLException;

	
	List<T> findAll() throws SQLException;
	
	boolean save(T o) throws SQLException, ParseException;
	
	boolean update(T o) throws SQLException;
	
	boolean delete(T o) throws SQLException;
}
