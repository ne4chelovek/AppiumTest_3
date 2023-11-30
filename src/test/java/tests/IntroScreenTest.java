package tests;
import extensions.MyExtension;
import org.junit.jupiter.api.extension.ExtendWith;
import screens.IntroScreen;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.net.MalformedURLException;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(MyExtension.class)
public class  IntroScreenTest extends BaseTest {

    private IntroScreen IntroScreen;


    @BeforeEach
    public void setUp() throws MalformedURLException {
        super.setUp();
        IntroScreen = new IntroScreen(getDriver());
    }

    @Test
    @DisplayName("Проверка, что поисковое поле активно")
    public void sampleTest() {
        IntroScreen.touchOutside();
        assertTrue(IntroScreen.checkSearchField(), "Поисковое поле не активно");
    }

    @Test
    @DisplayName("Отображение блока 'Специальные предложения!'")
    public void checkSpecialOffers(){
        IntroScreen.touchOutside();
        assertTrue(IntroScreen.checkAfterScroll(),"Баннер не отобразился");
    }


} 