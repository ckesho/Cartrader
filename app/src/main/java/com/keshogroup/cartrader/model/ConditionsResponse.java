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
    }

//    {
//        response: {
//            version: "0.1",
//                    termsofService: "http://www.wunderground.com/weather/api/d/terms.html",
//                    features: {
//                conditions: 1
//            }
//        },
//        current_observation: {
//            image: {
//                url: "http://icons.wxug.com/graphics/wu2/logo_130x80.png",
//                        title: "Weather Underground",
//                        link: "http://www.wunderground.com"
//            },
//            display_location: {
//                full: "Atlanta, GA",
//                        city: "Atlanta",
//                        state: "GA",
//                        state_name: "Georgia",
//                        country: "US",
//                        country_iso3166: "US",
//                        zip: "30328",
//                        magic: "1",
//                        wmo: "99999",
//                        latitude: "33.93402100",
//                        longitude: "-84.39462280",
//                        elevation: "328.00000000"
//            },
//            observation_location: {
//                full: "Overhill, Sandy Springs, Georgia",
//                        city: "Overhill, Sandy Springs",
//                        state: "Georgia",
//                        country: "US",
//                        country_iso3166: "US",
//                        latitude: "33.920361",
//                        longitude: "-84.414490",
//                        elevation: "978 ft"
//            },
//            estimated: { },
//            station_id: "KGAWOODS14",
//                    observation_time: "Last Updated on July 23, 11:43 AM EDT",
//                    observation_time_rfc822: "Thu, 23 Jul 2015 11:43:51 -0400",
//                    observation_epoch: "1437666231",
//                    local_time_rfc822: "Thu, 23 Jul 2015 11:51:58 -0400",
//                    local_epoch: "1437666718",
//                    local_tz_short: "EDT",
//                    local_tz_long: "America/New_York",
//                    local_tz_offset: "-0400",
//                    weather: "Partly Cloudy",
//                    temperature_string: "81.2 F (27.3 C)",
//                    temp_f: 81.2,
//                    temp_c: 27.3,
//                    relative_humidity: "82%",
//                    wind_string: "Calm",
//                    wind_dir: "NNE",
//                    wind_degrees: 30,
//                    wind_mph: 0,
//                    wind_gust_mph: 0,
//                    wind_kph: 0,
//                    wind_gust_kph: 0,
//                    pressure_mb: "1015",
//                    pressure_in: "29.97",
//                    pressure_trend: "0",
//                    dewpoint_string: "75 F (24 C)",
//                    dewpoint_f: 75,
//                    dewpoint_c: 24,
//                    heat_index_string: "87 F (31 C)",
//                    heat_index_f: 87,
//                    heat_index_c: 31,
//                    windchill_string: "NA",
//                    windchill_f: "NA",
//                    windchill_c: "NA",
//                    feelslike_string: "87 F (31 C)",
//                    feelslike_f: "87",
//                    feelslike_c: "31",
//                    visibility_mi: "10.0",
//                    visibility_km: "16.1",
//                    solarradiation: "--",
//                    UV: "7",
//                    precip_1hr_string: "0.00 in ( 0 mm)",
//                    precip_1hr_in: "0.00",
//                    precip_1hr_metric: " 0",
//                    precip_today_string: "0.00 in (0 mm)",
//                    precip_today_in: "0.00",
//                    precip_today_metric: "0",
//                    icon: "partlycloudy",
//                    icon_url: "http://icons.wxug.com/i/c/k/partlycloudy.gif",
//                    forecast_url: "http://www.wunderground.com/US/GA/Atlanta.html",
//                    history_url: "http://www.wunderground.com/weatherstation/WXDailyHistory.asp?ID=KGAWOODS14",
//                    ob_url: "http://www.wunderground.com/cgi-bin/findweather/getForecast?query=33.920361,-84.414490",
//                    nowcast: ""
//        }
//    }

}
