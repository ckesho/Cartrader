package com.keshogroup.cartrader.model;


public class ConditionsResponse {

    public Response response;

    public class Response {
        public String version;
        public String termsofService;

        public Features features;

        public class Features {
            public String conditions;
        }
    }

    public CurrentObservation currentObservation;

    public class CurrentObservation {
        public Image image;

        public class Image {
            public String url;
        }

        public DisplayLocation display_location;

        public class DisplayLocation {
            public String full;
            public String city;
            public String state;
            public String state_name;
            public String country;
            public String country_iso3166;
            public String zip;
            public String magic;
            public String wmo;
            public String latitude;
            public String longitude;
            public String evelation;
        }

        public ObservationLocation observation_location;

        public class ObservationLocation {
            public String full;
            public String city;
            public String state;
            public String country;
            public String country_iso3166;
            public String latitude;
            public String longitude;
            public String elevation;
        }

        public Estimated estimated;

        public class Estimated {

        }

        public String station_id;
        public String obervation_time;
        public String observation_time_rfc822;
        public String observation_epoch;
        public String local_time_rfc822;
        public String local_epoch;

        public String local_tz_short;
        public String local_tz_long;
        public String local_tz_offset;
        public String weather;
        public String temperature_string;
        public float temp_f;
        public float temp_c;
        public String relative_humidity;
        public String wind_string;
        public String wind_dir;
        public int wind_degrees;
        public int wind_mph;
        public int wind_gust_mph;
        public int wind_kph;
        public int wind_gust_kph;
        public String pressure_mb;
        public String pressure_in;
        public String pressure_trend;
        public String dewpoint_string;
        public int dewpoint_f;
        public int dewpoint_c;
        public String heat_index_string;
        public int heat_index_f;
        public String heat_index_c;
        public String windchill_string;
        public String windchill_f;
        public String windchill_c;
        public String feelslike_string;
        public String feelslike_f;
        public String feelslike_c;
        public String visibility_mi;
        public String visibility_km;
        public String solarradiation;
        public String UV;
        public String precip_1hr_string;
        public String precip_1hr_in;
        public String precip_1hr_metric;
        public String precip_today_string;
        public String precip_today_in;
        public String precip_today_metric;
        public String icon;
        public String icon_url;
        public String forecast_url;
        public String history_url;
        public String ob_url;
        public String nowcast;
    }

}
