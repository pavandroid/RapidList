# Rapidlist Library

Get rid of Adapters. Remove unnecessary boilerplate code in the names of Adapters. Used BindView for setting up the values. Library can handle multiple row types.
 - No more adapters
 - No View Holders
 - No setAdapters or notifyAdapters
 - No RecyclerList object required in Java/Kotlin Activity or Fragments.
 - Supports multiple row types
 - Create listview in less than 5 minutes
 - Operative from XML layouts
 - Your Model class of ArrayList is enough to create RecyclerView
 - Used Data Binding which is supported by latest Android SDK.
 - Works with LiveData
 - Lot more fun by avoiding boiler plate code and improve productivity.

# How to integrate the library

### Step1:
Add below code to app\build.gradle if not exists. This will enable the data binding in the entire project.
```gradle
dataBinding{
        enabled = true
    }
```

Add the JitPack repository to your build file
Add it in your root build.gradle at the end of repositories:
```
	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
```
Add the dependency
```
	dependencies {
	        implementation 'com.github.pavandroid:RapidList:9d015849b9'
	}
```

### Step2:
Create a model object where you will maintain an arraylist of any objects which you usually pass to RecyclerView Adapter. Make sure to maintain the Arraylist in the below manner for library to understand the Row information, types and layouts. check link https://github.com/pavandroid/RapidList/blob/master/app/src/main/java/com/uvr/rapidlist/model/RecyclerViewModel.java for more information on Model object creation. You can also create LiveData where the Listview automatically updated with live data changes.
```Java
    // This contains your array data. Row info should extend the abstarct class RapidRowData. 
    // Row ID's like BR.row1, BR.row2 etc will be dynamically created while build time. Clean and build if not available.
    public ArrayList<RapidRowData> arrayList = new ArrayList<>();
    // This is used to map Row ID's and Row layouts
    public HashMap<Integer, Integer> layoutsHashMap = new HashMap<>();
    // You can change the orientation and layouts(As usual like Recyclerview)
    public RecyclerView.LayoutManager linearLayoutManager;
```

### Step3:
 Create XML layouts with DataBinding
   1. Creating the RapidlerView in XML. You can do whatever you want here. This is to show how Data binding helps here..
   ```XML
   <?xml version="1.0" encoding="utf-8"?>
<layout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools">

    <data>

        <variable
            name="recyclerViewModel"
            type="com.uvr.rapidlist.model.RecyclerViewModel" />
    </data>

    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        tools:context="com.uvr.rapidlist.MainActivity">

        <com.uvr.rapidlistlibrary.recycler.RapidRecyclerView
            android:layout_width="match_parent"
            android:layout_height="match_parent"
            app:layoutManager="@{recyclerViewModel.linearLayoutManager}"
            app:contentArray="@{recyclerViewModel.arrayList}"
            app:rowLayouts="@{recyclerViewModel.layoutsHashMap}" />

    </LinearLayout>
</layout>
   ```
   2. Creating row layouts. You can do whatever you want here. This is to show how Data binding helps here..
   
   ```xml
<?xml version="1.0" encoding="utf-8"?>
<layout>

    <data>

        <variable
            name="row1"
            type="com.uvr.rapidlist.model.RapidRowModel1" />
    </data>

    <RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:padding="10dp">

        <TextView
            android:id="@+id/textView"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_alignParentLeft="true"
            android:layout_alignParentStart="true"
            android:layout_alignParentTop="true"
            android:layout_margin="8dp"
            android:text="@{row1.name}"
            android:textColor="@color/colorPrimary"
            android:textStyle="bold" />
    </RelativeLayout>
</layout>
   ```
   
##
You are all set to run the application.
# Library Screenshot

![](https://raw.githubusercontent.com/pavandroid/RapidList/master/screenshots/Capture.JPG)

> Sample Recyclerlist created.

[![](https://jitpack.io/v/pavandroid/RapidList.svg)](https://jitpack.io/#pavandroid/RapidList)



## Contributors

Thanks goes to Vinay Yamusani  https://github.com/bitfield66

