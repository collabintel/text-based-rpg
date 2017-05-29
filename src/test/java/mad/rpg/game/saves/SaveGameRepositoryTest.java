package mad.rpg.game.saves;

import mad.rpg.game.FileNames;
import mad.rpg.game.context.GameContext;
import mad.rpg.utils.FileDeserializer;
import mad.rpg.utils.FileSerializer;
import mad.rpg.utils.FileUtil;
import mad.rpg.utils.UtilLocator;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(PowerMockRunner.class)
@PrepareForTest({UtilLocator.class})
public class SaveGameRepositoryTest {

    @Mock
    UtilLocator utilLocator;

    @Mock
    FileSerializer fileSerializer;

    @Mock
    FileDeserializer fileDeserializer;

    @Mock
    FileUtil fileUtil;

    SaveGameRepository saveGameRepository;

    List<SaveGame> saveGames;

    @Before
    public void setUp() throws Exception {
        PowerMockito.mockStatic(UtilLocator.class);
        PowerMockito.when(UtilLocator.locate()).thenReturn(utilLocator);

        saveGameRepository = new SaveGameRepository();
        saveGames = new ArrayList<>();
        saveGames.add(new SaveGame(new GameContext()));
    }

    @Test
    public void should_getSavedGames_when_savedGamesCalled() throws Exception {
        when(utilLocator.fileDeserializer()).thenReturn(fileDeserializer);
        when(fileDeserializer.read(List.class, FileNames.SAVE_GAME)).thenReturn(saveGames);

        List<SaveGame> actualSaveGames = saveGameRepository.savedGames();

        assertThat(actualSaveGames).isEqualTo(saveGames);
    }

    @Test
    public void should_returnTrue_when_hasSavedGames() throws Exception {
        when(utilLocator.fileUtil()).thenReturn(fileUtil);
        when(utilLocator.fileDeserializer()).thenReturn(fileDeserializer);
        when(fileUtil.exists(FileNames.SAVE_GAME)).thenReturn(true);
        when(fileDeserializer.read(List.class, FileNames.SAVE_GAME)).thenReturn(saveGames);

        Boolean result = saveGameRepository.hasSavedGames();

        assertThat(result).isEqualTo(true);
    }

    @Test
    public void should_returnFalse_when_noSavedGames() throws Exception {
        when(utilLocator.fileUtil()).thenReturn(fileUtil);
        when(utilLocator.fileDeserializer()).thenReturn(fileDeserializer);
        when(fileUtil.exists(FileNames.SAVE_GAME)).thenReturn(true);
        when(fileDeserializer.read(List.class, FileNames.SAVE_GAME)).thenReturn(new ArrayList());

        Boolean result = saveGameRepository.hasSavedGames();

        assertThat(result).isEqualTo(false);
    }

    @Test
    public void should_returnFalse_when_fileDoesNotExist() throws Exception {
        when(utilLocator.fileUtil()).thenReturn(fileUtil);
        when(fileUtil.exists(FileNames.SAVE_GAME)).thenReturn(false);

        Boolean result = saveGameRepository.hasSavedGames();

        assertThat(result).isEqualTo(false);
    }

    @Test
    public void should_addSaveGame_when_saveGameCalled() throws Exception {
        when(utilLocator.fileUtil()).thenReturn(fileUtil);
        when(utilLocator.fileDeserializer()).thenReturn(fileDeserializer);
        when(utilLocator.fileSerializer()).thenReturn(fileSerializer);
        when(fileUtil.exists(FileNames.SAVE_GAME)).thenReturn(true);
        when(fileDeserializer.read(List.class, FileNames.SAVE_GAME)).thenReturn(saveGames);

        SaveGame saveGameNew = new SaveGame(new GameContext());

        saveGameRepository.saveGame(saveGameNew);

        verify(fileSerializer).write(saveGames, FileNames.SAVE_GAME);
    }
}
