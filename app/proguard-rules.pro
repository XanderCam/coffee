# Basic ProGuard rules for Android projects
-keep class com.example.coffeecounter.** { *; }
-keepclassmembers class com.example.coffeecounter.** { *; }

# Room database rules
-keep class * extends androidx.room.RoomDatabase
-keep class * extends androidx.room.Entity 
-keep class * extends androidx.room.Dao
-keepclassmembers class * {
    @androidx.room.* *;
}

# MPAndroidChart rules
-keep class com.github.mikephil.charting.** { *; }
-keep interface com.github.mikephil.charting.** { *; }

# Material Components rules  
-keep class com.google.android.material.** { *; }
-keep interface com.google.android.material.** { *; }

# Keep View bindings
-keepclassmembers class * extends android.view.View {
    public <init>(android.content.Context);
    public <init>(android.content.Context, android.util.AttributeSet);
    public <init>(android.content.Context, android.util.AttributeSet, int);
}

# Keep parcelable classes
-keep class * implements android.os.Parcelable {
    public static final android.os.Parcelable$Creator *;
}

# Keep serializable classes
-keepclassmembers class * implements java.io.Serializable {
    static final long serialVersionUID;
    private static final java.io.ObjectStreamField[] serialPersistentFields;
    private void writeObject(java.io.ObjectOutputStream);
    private void readObject(java.io.ObjectInputStream);
    java.lang.Object writeReplace();
    java.lang.Object readResolve();
}

# Keep annotations
-keepattributes *Annotation*