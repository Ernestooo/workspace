package FindConcertTicketInterface;
import java.time.LocalDate;

/**
 * 
 * @author Madalena Lopes 50577
 */
public interface ShowConcert extends Show {

	String getNameOfArtist();

	LocalDate getFirstDate();

	int getPrice();
}