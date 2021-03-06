package ch.andre601.revolt4j.api.objects;

import ch.andre601.revolt4j.api.objects.message.BaseFile;
import ch.andre601.revolt4j.api.objects.properties.Mentionable;
import ch.andre601.revolt4j.api.objects.properties.Snowflake;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.EnumSet;

/**
 * Interface representing a Revolt User.
 */
public interface User extends Snowflake, Mentionable{
    
    /**
     * {@inheritDoc}
     * 
     * @return ID of the user.
     */
    @Override
    @NotNull String getId();
    
    /**
     * {@inheritDoc}
     * 
     * @return The mention for this user.
     */
    @Override
    @NotNull String getAsMention();
    
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
     * Convenience method to directly get the URL of the User's avatar.
     * <br>This is equal to doing  <code>{@link #getAvatar()}.getUrl()</code>
     * 
     * @return The URL for the User's avatar.
     */
    @NotNull
    String getAvatarUrl();
    
    /**
     * The {@link Badge badges} the user can have.
     * <br>This may return an empty EnumSet when the user doesn't have any badges.
     * 
     * @return Not-null, possibly-empty EnumSet containing all the Badges the user currently has.
     */
    @NotNull
    EnumSet<Badge> getBadges();
    
    /**
     * Returns the raw integer value corresponding to this user's badges.
     * <br>You can use {@link Badge#getBadges(int) Badge.getBadges(getBadgesRaw())} or the dedicated
     * {@link #getBadges() getBadges() method} of this interface to get an EnumSet of the user's badges.
     * 
     * @return Integer representing the raw value of the user's badges or 0 if no Badges are available.
     * 
     * @see #getBadges() EnumSet&lt;Badge&gt;: getBadges()
     */
    int getBadgesRaw();
    
    /**
     * The current {@link Status status} of the user.
     * <br>The status may contain a {@link Status#getText() custom text} that is displayed as the user's presence.
     *
     * @return Not-null instance of the user's status.
     */
    @NotNull
    Status getStatus();
    
    /**
     * The current {@link Relationship relationship} the user has with the bot.
     * <br>The relationship will always be <b>from the bots perspective.</b>
     * 
     * @return Not-null current Relationship of the bot with the user.
     */
    @NotNull
    Relationship getRelationship();
    
    /**
     * Will return true or false depending on if the user is currently online or not.
     * 
     * @return Whether this user is online.
     */
    boolean isOnline();
    
    /**
     * The {@link Flag flags} the user may have.
     * <br>Flags indicate a specific state of the user's account and can influence the availability of certain
     * values. This may return an empty EnumSet if the user doesn't have any flags.
     * 
     * @return Not-null, possibly-empty EnumSet containing all the flags the user currently has.
     */
    @NotNull
    EnumSet<Flag> getFlags();
    
    /**
     * Gets the raw integer value representing the current flags of the user.
     * <br>You can use {@link Flag#getFlags(int) Flag.getFlags(getFlagsRaw())} or the dedicated
     * {@link #getFlags() getFlags() method} of this interface to get an EnumSet of the user's flags.
     * 
     * @return Integer representing the raw value of the user's flags or 0 if no flags are set.
     * 
     * @see #getFlags() EnumSet&lt;Flag&gt;: getFlags()
     */
    int getFlagsRaw();
    
    /**
     * The avatar of the User.
     * <br>The avatar will have a unique ID and also a URL.
     */
    interface Avatar extends BaseFile{
    
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
    
    /**
     * The current status/presence the user has. May have a custom text if the user set one.
     */
    interface Status{
    
        /**
         * The custom text displayed as the user's status.
         * <br>Will return null if no custom text is present.
         * 
         * @return Nullable String representing the text of the user's custom status.
         */
        @Nullable
        String getText();
    
        /**
         * The type of {@link PresenceType presence} a user can have.
         * <br>This may return {@link PresenceType#UNKNOWN UNKNOWN} if an unknown presence was set.
         * 
         * @return PresenceType instance representing the current status of the user.
         */
        @NotNull
        PresenceType getPresence();
    }
    
    /**
     * Enum containing possible badges a user can have.
     * 
     * <p>Use {@link User#getBadges() User.getBadges()} for an EnumSet of the user's badges or
     * {@link User#getBadgesRaw() User.getBadgesRaw()} for the raw integer value instead.
     */
    enum Badge{
        /**
         * User is a developer for the Revolt application.
         */
        DEVELOPER             (0, "Developer"),
        /**
         * User has translated a significant portion of the Revolt app into another language.
         */
        TRANSLATOR            (1, "Translator"),
        /**
         * User donated to the devs of Revolt.
         */
        SUPPORTER             (2, "Supporter"),
        /**
         * TODO: Find out what this means.
         */
        RESPONSIBLE_DISCLOSURE(3, "Responsible Disclosure"),
        /**
         * User is a member of the Revolt team.
         */
        REVOLT_TEAM           (4, "Revolt Staff"),
        /**
         * User was one of the very first users using Revolt.
         */
        EARLY_ADOBTER         (8, "Early Adobter"),
    
        /**
         * An unknown badge the user has. If this is returned does it mean that Revolt has a new badge not yet known
         * by Revolt4J.
         */
        UNKNOWN(-1, "Unknown");
        
        private final int offset;
        private final int raw;
        private final String name;
        
        Badge(int offset, String name){
            this.offset = offset;
            this.raw = 1 << offset;
            this.name = name;
        }
    
        /**
         * Get the name of the badge as used by the Revolt client.
         * 
         * @return The name of the badge as displayed in the Revolt client.
         */
        @NotNull
        public String getName(){
            return name;
        }
        
        public int getOffset(){
            return offset;
        }
    
        public int getRaw(){
            return raw;
        }
    
        /**
         * Get a Badge from the provided offset value.
         * 
         * @param  offset
         *         The offset to get a badge from.
         * 
         * @return The Badge matching the provided offset, or {@link #UNKNOWN UNKNOWN} if no known badge is found.
         */
        @NotNull
        public static Badge getFromOffset(int offset){
            for(Badge badge : values()){
                if(badge.offset == offset)
                    return badge;
            }
            
            return UNKNOWN;
        }
    
        /**
         * Gets an EnumSet of badges matching the provided raw bitfield value.
         * 
         * @param  badges
         *         Raw bitfield representing the set of badges to get.
         * 
         * @return Not-null, possibly empty EnumSet containing Badges matching the provided bitfield.
         */
        @NotNull
        public static EnumSet<Badge> getBadges(int badges){
            final EnumSet<Badge> foundBadges = EnumSet.noneOf(Badge.class);
            
            if(badges == 0)
                return foundBadges; // No badges
            
            for(Badge badge : values()){
                if(badge != UNKNOWN && (badges & badge.raw) == badge.raw)
                    foundBadges.add(badge);
            }
            
            return foundBadges;
        }
    }
    
    /**
     * The current relationship a user has.
     * <br>The relationship listed here is <b>always</b> in comparison with the used account.
     * <br>This means that a relationship of {@link Relationship#BLOCKED BLOCKED} means that the user has
     * blocked the account you use Revolt4J on.
     */
    enum Relationship{
        /**
         * The user is blocked.
         */
        BLOCKED,
        /**
         * TODO: What does this mean?
         */
        BLOCKED_OTHER,
        /**
         * The bot is friends with the user.
         */
        FRIEND,
        /**
         * The bot has an incoming Friend request of the user.
         */
        INCOMING,
        /**
         * The bot does not have any specific relationship with the user.
         */
        NONE,
        /**
         * The bot has an outgoing Friend request to this user.
         */
        OUTGOING,
        /**
         * TODO: What does this mean?
         */
        USER;
        
        Relationship(){}
        
        @NotNull
        public static Relationship getFromString(String relationshipName){
            for(Relationship relationship : values()){
                if(relationship.name().equalsIgnoreCase(relationshipName))
                    return relationship;
            }
    
            return NONE;
        }
    }
    
    enum PresenceType{
        
        ONLINE,
        IDLE,
        BUSY,
        INVISIBLE,
        UNKNOWN;
        
        PresenceType(){}
        
        public static PresenceType getFromString(String presenceName){
            for(PresenceType type : values()){
                if(type.name().equalsIgnoreCase(presenceName))
                    return type;
            }
            
            return UNKNOWN;
        }
    }
    
    enum Flag{
        /**
         * The user account has been suspended.
         */
        SUSPENDED(0, "Suspended"),
        /**
         * The user account has been deleted.
         */
        DELETED(1, "Deleted"),
        /**
         * The user account has been banned.
         * <br><b>This is NOT a Guild ban!</b>
         */
        BANNED(2, "Banned"),
    
        /**
         * An unknown flag is set for this user. This <i>should</i> never appear unless Revolt adds a new flag.
         */
        UNKNOWN(-1, "Unknown");
        
        private final int offset;
        private final int raw;
        private final String name;
        
        Flag(int offset, String name){
            this.offset = offset;
            this.raw = 1 << offset;
            this.name = name;
        }
        
        @NotNull
        public String getName(){
            return name;
        }
    
        public int getRaw(){
            return raw;
        }
    
        public int getOffset(){
            return offset;
        }
        
        public static Flag getFromOffset(int offset){
            for(Flag flag : values()){
                if(flag.offset == offset)
                    return flag;
            }
            
            return UNKNOWN;
        }
        
        public static EnumSet<Flag> getFlags(int flags){
            final EnumSet<Flag> foundFlags = EnumSet.noneOf(Flag.class);
            
            if(flags == 0)
                return foundFlags; // No flags
            
            for(Flag flag : values()){
                if(flag != null && (flags & flag.raw) == flag.raw)
                    foundFlags.add(flag);
            }
            
            return foundFlags;
        }
    }
}
