
import java.util.Objects;

/**
 * A class to organize cultural events.
 */

class CulturalEventOrganizer {
   private CulturalEventBuilder culturalEventBuilder;

   public void setCulturalEventBuilder(CulturalEventBuilder ceb) {
       culturalEventBuilder = ceb;
   }

    public CulturalEventBuilder getCulturalEventBuilder() {
        return culturalEventBuilder;
    }

    public CulturalEvent getCulturalEvent() {
        return culturalEventBuilder.getCulturalEvent();
    }


    @Override
    public String toString() {
        return "CultureEventOrganizer{" +
                "cultureEventBuilder=" + culturalEventBuilder +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CulturalEventOrganizer that = (CulturalEventOrganizer) o;
        return Objects.equals(culturalEventBuilder, that.culturalEventBuilder);
    }

    @Override
    public int hashCode() {
        return Objects.hash(culturalEventBuilder);
    }


}