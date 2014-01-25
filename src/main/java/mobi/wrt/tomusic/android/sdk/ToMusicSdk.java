package mobi.wrt.tomusic.android.sdk;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.widget.Toast;

import java.util.ArrayList;

public class ToMusicSdk {

    public static final String ACTION_PLAY = "mobi.wrt.tomusic.android.sdk.ACTION_PLAY";
    public static final String EXTRA_TRACKS = "tracks";
    public static final String EXTRA_CURRENT_POSITION = "current_position";
    private static final String TO_MUSIC_APP_PACKAGE = "by.istin.android.vkmusic";

    public static void play(final Context context, final ArrayList<PublicTrack> tracks, final int currentPosition) {
        if (isAppInstalled(context, TO_MUSIC_APP_PACKAGE)) {
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    Intent intent = new Intent(ACTION_PLAY);
                    intent.putExtra(EXTRA_TRACKS, tracks);
                    intent.putExtra(EXTRA_CURRENT_POSITION, currentPosition);
                    context.startService(intent);
                }
            });
            thread.setPriority(Thread.MIN_PRIORITY);
            thread.start();
        } else {
            openBrowser(context, "market://details?id="+TO_MUSIC_APP_PACKAGE);
        }
    }

    private static boolean isAppInstalled(Context context, String packageName) {
        PackageManager pm = context.getPackageManager();
        boolean installed;
        try {
            pm.getPackageInfo(packageName, PackageManager.GET_ACTIVITIES);
            installed = true;
        } catch (PackageManager.NameNotFoundException e) {
            installed = false;
        }
        return installed;
    }

    /**
     * Open browser.
     *
     * @param context the context
     * @param url     the url
     */
    private static void openBrowser(Context context, String url) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        try {
            context.startActivity(intent);
        } catch (ActivityNotFoundException e) {
            Toast.makeText(context, "Please install browser", Toast.LENGTH_SHORT).show();
        }
    }
}
