package com.sammymanunggal.tugasBesarPBP;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.mapbox.android.core.permissions.PermissionsListener;
import com.mapbox.android.core.permissions.PermissionsManager;
import com.mapbox.api.directions.v5.models.DirectionsResponse;
import com.mapbox.api.directions.v5.models.DirectionsRoute;
import com.mapbox.api.geocoding.v5.models.CarmenFeature;
import com.mapbox.geojson.Feature;
import com.mapbox.geojson.FeatureCollection;
import com.mapbox.geojson.Point;
import com.mapbox.mapboxsdk.Mapbox;
import com.mapbox.mapboxsdk.camera.CameraPosition;
import com.mapbox.mapboxsdk.camera.CameraUpdateFactory;
import com.mapbox.mapboxsdk.geometry.LatLng;
import com.mapbox.mapboxsdk.location.LocationComponent;
import com.mapbox.mapboxsdk.location.LocationComponentActivationOptions;
import com.mapbox.mapboxsdk.location.modes.CameraMode;
import com.mapbox.mapboxsdk.location.modes.RenderMode;
import com.mapbox.mapboxsdk.maps.MapView;
import com.mapbox.mapboxsdk.maps.MapboxMap;
import com.mapbox.mapboxsdk.maps.OnMapReadyCallback;
import com.mapbox.mapboxsdk.maps.Style;
import com.mapbox.mapboxsdk.plugins.places.autocomplete.PlaceAutocomplete;
import com.mapbox.mapboxsdk.style.layers.SymbolLayer;
import com.mapbox.mapboxsdk.style.sources.GeoJsonSource;
import com.mapbox.services.android.navigation.ui.v5.NavigationLauncher;
import com.mapbox.services.android.navigation.ui.v5.NavigationLauncherOptions;
import com.mapbox.services.android.navigation.ui.v5.route.NavigationMapRoute;
import com.mapbox.services.android.navigation.v5.navigation.NavigationRoute;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.mapbox.mapboxsdk.style.layers.PropertyFactory.iconAllowOverlap;
import static com.mapbox.mapboxsdk.style.layers.PropertyFactory.iconIgnorePlacement;
import static com.mapbox.mapboxsdk.style.layers.PropertyFactory.iconImage;

public class MapActivity extends AppCompatActivity implements OnMapReadyCallback, PermissionsListener {

    private static final String DESTINATION_SYMBOL_LAYER_ID = "destination-symbol-layer-id";
    private static final String DESTINATION_ICON_ID = "destination-icon-id";
    private static final String DESTINATION_SOURCE_ID = "destination-source-id";
    private static final int REQUEST_CODE_AUTOCOMPLETE =1;
    private PermissionsManager permissionsManager;
    private MapboxMap mapboxMap;
    private MapView mapView;
    private Point originPoint, origin, destinationPoint;
    private Button button,buttonBack;
    private DirectionsRoute currentRoute;
    private static final String TAG = "DirectionsActivity";
    private NavigationMapRoute navigationMapRoute;


    public Bundle mBundle;
    public String lokasiMuseum;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Mapbox.getInstance(this, getString(R.string.mapbox_access_token));

        setContentView(R.layout.activity_map);

        mapView = findViewById(R.id.mapView);

        mapView.onCreate(savedInstanceState);
        mapView.getMapAsync(this);



        button = findViewById(R.id.startButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean simulateRoute = true;
                NavigationLauncherOptions options = NavigationLauncherOptions.builder()
                        .directionsRoute(currentRoute)
                        .shouldSimulateRoute(simulateRoute)
                        .build();
                NavigationLauncher.startNavigation(MapActivity.this, options);
            }
        });



    }


    private void initLayer(@NonNull Style loadedMapStyle){
        loadedMapStyle.addImage(DESTINATION_ICON_ID,
                BitmapFactory.decodeResource(this.getResources(), R.drawable.mapbox_marker_icon_default));
        GeoJsonSource geoJsonSource = new GeoJsonSource(DESTINATION_SOURCE_ID);
        loadedMapStyle.addSource(geoJsonSource);
        SymbolLayer destinationSymbolLayer = new SymbolLayer(DESTINATION_SYMBOL_LAYER_ID, DESTINATION_SOURCE_ID);
        destinationSymbolLayer.withProperties(
                iconImage(DESTINATION_ICON_ID),
                iconAllowOverlap(true),
                iconIgnorePlacement(true)
        );
        loadedMapStyle.addLayer(destinationSymbolLayer);
    }

    @SuppressLint("MissingPermission")
    private void enableLocationComponent(@NonNull Style loadedMapStyle){
        if (PermissionsManager.areLocationPermissionsGranted(this)){
            LocationComponent locationComponent = mapboxMap.getLocationComponent();

            locationComponent.activateLocationComponent(
                    LocationComponentActivationOptions.builder(this, loadedMapStyle).build()

            );

            locationComponent.setLocationComponentEnabled(true);

            locationComponent.setCameraMode(CameraMode.TRACKING);

            locationComponent.setRenderMode(RenderMode.COMPASS);

            this.origin =
                    Point.fromLngLat(locationComponent.getLastKnownLocation().getLongitude(),
                            locationComponent.getLastKnownLocation().getLatitude());

        } else {
            permissionsManager = new PermissionsManager(this);
            permissionsManager.requestLocationPermissions(this);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    @Override
    public void onExplanationNeeded(List<String> permissionsToExplain) {
        Toast.makeText(this, "Grant Location Permission", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onPermissionResult(boolean granted) {
        if(granted){

        } else{
            Toast.makeText(this, "Permission not granted", Toast.LENGTH_LONG).show();
            finish();
        }
    }

    @Override
    public void onMapReady(@NonNull MapboxMap mapboxMap) {
        this.mapboxMap = mapboxMap;

        List<Feature> symbolLayerIconFeatureList = new ArrayList<>();

        //SET LOKASI TIAP MUSEUM
        mBundle= getIntent().getBundleExtra("nama");
        lokasiMuseum=mBundle.getString("nama");
        if(lokasiMuseum.equals("Museum Keraton")) {
            symbolLayerIconFeatureList.add(Feature.fromGeometry(
                    Point.fromLngLat(110.360630, -7.806960)));
        } else if(lokasiMuseum.equals("Museum Jogja Kembali")) {
            symbolLayerIconFeatureList.add(Feature.fromGeometry(
                    Point.fromLngLat(110.368850, -7.749740)));
        } else if(lokasiMuseum.equals("Museum Vredeburg")) {
            symbolLayerIconFeatureList.add(Feature.fromGeometry(
                    Point.fromLngLat(110.3662919998169, -7.799991858576539)));
        } else if(lokasiMuseum.equals("Museum Sandi")) {
            symbolLayerIconFeatureList.add(Feature.fromGeometry(
                    Point.fromLngLat(110.37115044585673, -7.784602550000001)));
        }else if(lokasiMuseum.equals("Museum Merapi")) {
            symbolLayerIconFeatureList.add(Feature.fromGeometry(
                    Point.fromLngLat(110.42419312377405, -7.61604015)));
        }else if(lokasiMuseum.equals("Museum Affandi")) {
            symbolLayerIconFeatureList.add(Feature.fromGeometry(
                    Point.fromLngLat(110.3963430835811, -7.78279705)));
        }


        //MENCARI LOKASI TAMBAHAN


        mapboxMap.setStyle(new Style.Builder().fromUri(Style.MAPBOX_STREETS),
                new Style.OnStyleLoaded(){
                    @Override
                    public void onStyleLoaded(@NonNull Style style) {
                        final Feature[] symbolLayerIconFeatureList = new Feature[1];
                        enableLocationComponent(style);


                    if(lokasiMuseum.equals("Museum Keraton")){
                        Toast.makeText(MapActivity.this, "MENGARAHKAN KE KRATON YOGYAKARTA", Toast.LENGTH_LONG).show();
                        getRoute(origin, Point.fromLngLat(110.360630, -7.806960));

                    } else if(lokasiMuseum.equals("Museum Jogja Kembali")){
                        Toast.makeText(MapActivity.this, "MENGARAHKAN KE Museum Jogja Kembali", Toast.LENGTH_LONG).show();
                        getRoute(origin, Point.fromLngLat(110.368850, -7.749740));

                    } else if(lokasiMuseum.equals("Museum Vredeburg")){
                        Toast.makeText(MapActivity.this, "MENGARAHKAN KE Museum Vredeburg", Toast.LENGTH_LONG).show();
                        getRoute(origin, Point.fromLngLat(110.3662919998169, -7.799991858576539));

                    }else if(lokasiMuseum.equals("Museum Sandi")){
                        Toast.makeText(MapActivity.this, "MENGARAHKAN KE Museum Sandi", Toast.LENGTH_LONG).show();
                        getRoute(origin, Point.fromLngLat(110.37115044585673, -7.784602550000001));

                    }else if(lokasiMuseum.equals("Museum Merapi")){
                        Toast.makeText(MapActivity.this, "MENGARAHKAN KE Museum Merapi", Toast.LENGTH_LONG).show();
                        getRoute(origin, Point.fromLngLat(110.42419312377405, -7.61604015));

                    }else if(lokasiMuseum.equals("Museum Affandi")){
                        Toast.makeText(MapActivity.this, "MENGARAHKAN KE Museum Affandi", Toast.LENGTH_LONG).show();
                        getRoute(origin, Point.fromLngLat(110.3963430835811, -7.78279705));

                    }







                        //SESUAI TUJUAN YANG ADA LONGITITUDE NYA
                        button.setEnabled(true);
                        button.setBackgroundResource(R.color.mapboxBlue);



                    }
                }

        );
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == Activity.RESULT_OK && requestCode == REQUEST_CODE_AUTOCOMPLETE) {
            CarmenFeature selectedCarmenFeature = PlaceAutocomplete.getPlace(data);

            if (mapboxMap != null) {
                Style style = mapboxMap.getStyle();
                if (style != null) {
                    GeoJsonSource source = style.getSourceAs("geojsonSourceLayerId");
                    if (source != null) {
                        source.setGeoJson(FeatureCollection.fromFeatures(
                                new Feature[]{Feature.fromJson(selectedCarmenFeature.toJson())}
                        ));
                    }
                    mapboxMap.animateCamera(CameraUpdateFactory.newCameraPosition(
                            new CameraPosition.Builder()
                                    .target(new LatLng(((Point) selectedCarmenFeature.geometry()).latitude(),
                                            ((Point) selectedCarmenFeature.geometry()).longitude()))
                                    .zoom(14)
                                    .build()), 4000);

                }
            }
        }
    }

    private void getRoute(Point origin, Point destination) {
        NavigationRoute.builder(this)
                .accessToken(Mapbox.getAccessToken())
                .origin(origin)
                .destination(destination)
                .build()
                .getRoute(new Callback<DirectionsResponse>() {
                    @Override
                    public void onResponse(Call<DirectionsResponse> call, Response<DirectionsResponse> response) {

                        Log.d(TAG, "Response code: " + response.code());
                        if (response.body() == null) {
                            Log.e(TAG, "No routes found, make sure you set the right user and access token.");
                            return;
                        } else if (response.body().routes().size() < 1) {
                            Log.e(TAG, "No routes found");
                            return;
                        }

                        currentRoute = response.body().routes().get(0);

                        if (navigationMapRoute != null) {
                            navigationMapRoute.removeRoute();
                        } else {
                            navigationMapRoute = new NavigationMapRoute(null, mapView, mapboxMap, R.style.NavigationMapRoute);
                        }
                        navigationMapRoute.addRoute(currentRoute);
                    }

                    @Override
                    public void onFailure(Call<DirectionsResponse> call, Throwable throwable) {
                        Log.e(TAG, "Error: " + throwable.getMessage());
                    }
                });
    }

    @Override
    protected void onStart() {
        super.onStart();
        mapView.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
        mapView.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        mapView.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
        mapView.onStop();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        mapView.onSaveInstanceState(outState);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mapView.onDestroy();
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        mapView.onLowMemory();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.map_style, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_outdoors:
                mapboxMap.setStyle(Style.OUTDOORS);
                return true;
            case R.id.menu_satellite:
                mapboxMap.setStyle(Style.SATELLITE);
                return true;
            case android.R.id.home:
                finish();
                return true;
            case R.id.menu_streets:
                mapboxMap.setStyle(Style.MAPBOX_STREETS);
                return true;
            case R.id.menu_dark:
                mapboxMap.setStyle(Style.DARK);
                return true;
            case R.id.menu_light:
                mapboxMap.setStyle(Style.LIGHT);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}