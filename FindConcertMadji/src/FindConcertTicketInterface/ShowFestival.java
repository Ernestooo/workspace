package FindConcertTicketInterface;
import java.time.LocalDate;
import java.util.*;

/**
 * 
 * @author Madalena Lopes 50577
 */
public interface ShowFestival extends Show {

	LocalDate getFirstDate();

	void setLastDate(LocalDate firstDate);

	List<LocalDate> getLastDate();

	int getNumberOfDays();

	String[] getArtistByDay(int day);

	Iterator<String> getArtists(int day);

	int getPriceByDays(int day);
}