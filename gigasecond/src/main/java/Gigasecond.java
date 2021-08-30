import java.time.LocalDate;
import java.time.LocalDateTime;

public class Gigasecond {

    private static final long GIGASECONDES = 1_000_000_000;
    private LocalDateTime moment;

    public Gigasecond(LocalDate moment) {
        this(moment.atStartOfDay());
    }

    public Gigasecond(LocalDateTime moment) {
        this.moment = moment.plusSeconds(GIGASECONDES);
    }

    public LocalDateTime getDateTime() {
        return this.moment;
    }
}
