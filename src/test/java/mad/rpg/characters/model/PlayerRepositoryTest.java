//package mad.rpg.characters.model;
//
//import org.junit.Before;
//import org.junit.Test;
//
//import java.util.List;
//import java.util.Optional;
//
//import static org.assertj.core.api.Assertions.assertThat;
//
//public class PlayerRepositoryTest {
//
//    CharacterRepository playerRepository;
//
//    Character player;
//
//    @Before
//    public void setUp() throws Exception {
//        playerRepository = new PlayerRepository();
//        player = new Player(null, null);
//    }
//
//    @Test
//    public void should_addPlayer_when_addCalled() throws Exception {
//        playerRepository
//                .add(player)
//                .add(new Player(null,null));
//
//        List<Character> characters = playerRepository.characters();
//
//        assertThat(characters)
//                .hasSize(2)
//                .contains(player);
//    }
//
//    @Test
//    public void should_getSelectedPlayers_when_characterCalled() throws Exception {
//        playerRepository
//                .add(new Player(null,null))
//                .add(player)
//                .add(new Player(null,null));
//
//        Optional<Character> resultPlayer = playerRepository.character(2);
//
//        assertThat(resultPlayer.get()).isEqualTo(player);
//    }
//
//    @Test
//    public void should_getEmptyValue_when_characterCalledWithIndexNotFound() throws Exception {
//        playerRepository.add(player);
//
//        Optional<Character> resultPlayer = playerRepository.character(5);
//
//        assertThat(resultPlayer.isPresent()).isEqualTo(false);
//    }
//}
