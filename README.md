<h1>BUILDING</h1>

1. Clone repo
2. Import into AndroidStudio by select6ing build.gradle in the base directory.
3. Build!

<h1>PERSONALIZING</h1>
To add your own pictures, update the files in the Love/src/main/res/drawable
folder. 

To add/change titles, edit Love/src/main/res/values/strings.xml. Look
for "TODO" in the file. The first one you see is the application title (what
shows up in the list of applications and title bar). The second set is the
titles shown inthe navigation drawer.

To map your new titles and images, edit LoveActivity.java:

    /**
     * Maps the titles and images for display.
     *
     * TODO: Swap these strings and drawable ids for your own pictures
     *       and titles.
     *          - Replace the strings in res/values/strings.xml
     *          - Replace the drawables in the res/drawable/ folder
     */
    private void setUpLoveItems ()
    {
        viewDataItems = new ArrayList<ViewDataItem>();
        viewDataItems.add( new ViewDataItem( getString( R.string.your_new_name ), R.drawable.your_new_picture_minus_extension ) );
    }

The order you add them here is the order they will appear.

Enjoy!
