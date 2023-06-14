package Canva;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyDesignService implements DesignService{
    // Maps userid to designs
    Map<String, List<String>> inMemoryOwnerships = new HashMap<>();
    Map<String, Design> inMemoryDesigns = new HashMap<>();

    // Mapping design ids to other users
    Map<String, List<String>> sharedWith = new HashMap<>();

    public void shareDesign(AuthContext ctx, String designId, String targetUserId) {
//        designId.length();
//        designId.substring(1);

        // Check ownership
        if (getDesign(ctx, designId) == null) {
            return;
        }

        // Share it
        if (!sharedWith.containsKey(designId)) {
            sharedWith.put(designId, new ArrayList<>());
        }

        (sharedWith.get(designId)).add(targetUserId);
    }

    public MyDesignService () {}
    @Override
    public String createDesign(AuthContext ctx, String designContent) {
        Design design = new Design(ctx, designContent);

        if (!inMemoryOwnerships.containsKey(ctx.userId)) {
            inMemoryOwnerships.put(ctx.userId, new ArrayList<>());
        }

        List<String> userDesigns = inMemoryOwnerships.get(ctx.userId);
        userDesigns.add(design.getId());

        inMemoryDesigns.put(design.getId(), design);

        return design.getId();
    }

    @Override
    public String getDesign(AuthContext ctx, String designId) {
        if (
            !inMemoryOwnerships.containsKey(ctx.userId)
            && !sharedWith.containsKey(designId)
        ) {
            return null;
        }

        List<String> userDesigns = inMemoryOwnerships.get(ctx.userId);

        if (userDesigns != null && userDesigns.contains(designId)) {
            return inMemoryDesigns.get(designId).getDesignContent();
        }

        if (
            sharedWith.containsKey(designId)
            && sharedWith.get(designId).contains(ctx.userId)
        ) {
            return inMemoryDesigns.get(designId).getDesignContent();
        }

        return null;
    }

    @Override
    public List<String> findDesigns(AuthContext ctx) {
        if (!inMemoryOwnerships.containsKey(ctx.userId)) {
            return null;
        }

        return inMemoryOwnerships.get(ctx.userId);
    }


}

