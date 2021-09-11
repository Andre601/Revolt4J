package ch.andre601.revolt4j.api.objects;

import org.jetbrains.annotations.NotNull;

/**
 * Interface representing a Revolt User.
 */
public interface User{
    
    /**
     * The ID of the User.
     * <br>The ID will always be 26 characters long and will be alphanumeric.
     * 
     * @return ID of the User.
     */
    @NotNull
    String getId();
    
    /**
     * The Displayed name of the user.
     * <br>The username will never be less than 2 and not more than 32 characters long.
     * 
     * @return Name of the User.
     */
    @NotNull
    String getName();
    
    /**
     * The {@link Avatar User's Avatar}.
     * <br>If you want to only get the Link for the Avatar should you use {@link #getAvatarUrl()} instead.
     * 
     * @return Avatar instance of the User.
     */
    @NotNull
    Avatar getAvatar();
    
    /**
     * Convenience method to directly get the avatar.
     * <br>This is equal to doing  <code>{@link #getAvatar()}.getUrl()</code>
     * 
     * @return The URL for the User's avatar.
     */
    @NotNull
    String getAvatarUrl();
    
    interface Avatar{
    
        /**
         * The ID of the User's avatar.
         * 
         * @return ID of the Avatar.
         */
        @NotNull
        String getId();
    
        /**
         * The URL used for the User's avatar.
         * 
         * @return URL of the avatar.
         */
        @NotNull
        String getUrl();
    }
}
