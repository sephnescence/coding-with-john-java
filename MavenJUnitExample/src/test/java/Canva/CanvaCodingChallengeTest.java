package Canva;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CanvaCodingChallengeTest {
    @Test
    void testTrue() {
        assertTrue(true);
    }

    @Test
    void testCanCreateDesign() {
        String userId = "Blake";
        AuthContext auth = new AuthContext(userId);

        MyDesignService designService = new MyDesignService();

        String blakeDesignId = designService.createDesign(auth, "Test content");
        assertNotNull(blakeDesignId);

        String paulUserId = "Paul";
        AuthContext paulAuth = new AuthContext(paulUserId);

        String blakeDesign = designService.getDesign(paulAuth, blakeDesignId);
        assertNull(blakeDesign);

        blakeDesign = designService.getDesign(auth, blakeDesignId);
        assertEquals(blakeDesign, "Test content");
    }

    @Test
    void testFindDesigns() {
        String userId = "Blake";
        AuthContext auth = new AuthContext(userId);
        MyDesignService designService = new MyDesignService();

        String testContent1Id = designService.createDesign(auth, "Test content 1");
        String testContent2Id = designService.createDesign(auth, "Test content 2");
        String testContent3Id = designService.createDesign(auth, "Test content 3");

        List<String> userDesigns = designService.findDesigns(auth);
        assertEquals(userDesigns.size(), 3);

        assertTrue(userDesigns.contains(testContent1Id));
        assertTrue(userDesigns.contains(testContent2Id));
        assertTrue(userDesigns.contains(testContent3Id));
    }

    @Test
    void testCanShare() {
        String userId = "Blake";
        AuthContext auth = new AuthContext(userId);

        MyDesignService designService = new MyDesignService();

        String blakeDesignId = designService.createDesign(auth, "Test content");
        assertNotNull(blakeDesignId);

        String paulUserId = "Paul";
        AuthContext paulAuth = new AuthContext(paulUserId);

        String blakeDesign = designService.getDesign(paulAuth, blakeDesignId);
        assertNull(blakeDesign);

        designService.shareDesign(paulAuth, blakeDesignId, paulUserId);

        blakeDesign = designService.getDesign(paulAuth, blakeDesignId);
        assertNull(blakeDesign);

        designService.shareDesign(auth, blakeDesignId, paulUserId);

        blakeDesign = designService.getDesign(paulAuth, blakeDesignId);
        assertEquals(blakeDesign, "Test content");
    }

}