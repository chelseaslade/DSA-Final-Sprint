import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.keyin.BST;
import org.keyin.BSTEntity;
import org.keyin.BSTRepository;
import org.keyin.BSTService;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@ExtendWith(MockitoExtension.class)
public class bstTests {
    @Mock
    private BSTRepository bstRepository;

    @InjectMocks
    private BSTService bstService;

    @Test
    void clearNodes() {
        BST bst = new BST();
        bst.insert(2);
        bst.insert(3);
        bst.clear();
        assertNull(bst.getRoot());
    }

    @Test
    void getRootValue() {
        BST bst = new BST();
        bst.insert(2);
        bst.insert(3);
        assertEquals(2, bst.getRootValue());
    }

    @Test
    void treeJSONReturn() {
        BSTEntity bstEntity = new BSTEntity();
        bstEntity.setInputNumbers("2, 6, 3");
        String testNums = bstEntity.getInputNumbers();
        String JSONresult = bstService.buildAndStoreTree(testNums);
        assertEquals("{\"value\":2,\"left\":null,\"right\":{\"value\":6,\"left\":{\"value\":3,\"left\":null,\"right\":null},\"right\":null}}", JSONresult);
    }
}
