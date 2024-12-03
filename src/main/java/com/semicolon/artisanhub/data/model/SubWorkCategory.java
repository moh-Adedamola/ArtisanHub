package com.semicolon.artisanhub.data.model;

import lombok.Getter;


@Getter

public enum SubWorkCategory {
    CROP_FARMING(WorkCategory.AGRICULTURE,"AGRICULTURE"),
    LIVESTOCK_FARMING(WorkCategory.AGRICULTURE,"AGRICULTURE"),
    AGRO_PROCESSING(WorkCategory.AGRICULTURE, "Agro-Processing"),


    EXPLORATION(WorkCategory.OIL_AND_GAS, "Exploration and Production"),
    REFINING(WorkCategory.OIL_AND_GAS, "Refining"),
    PIPELINE_MANAGEMENT(WorkCategory.OIL_AND_GAS, "Pipeline Management"),
    DISTRIBUTION(WorkCategory.OIL_AND_GAS,"distribution"),


    SOFTWARE_DEVELOPMENT(WorkCategory.IT_AND_TELECOMMUNICATION_SYSTEM, "Software Development"),
    NETWORK_ENGINEERING(WorkCategory.IT_AND_TELECOMMUNICATION_SYSTEM, "Network Engineering"),
    CYBERSECURITY(WorkCategory.IT_AND_TELECOMMUNICATION_SYSTEM, "Cybersecurity"),
    IT_SUPPORT(WorkCategory.IT_AND_TELECOMMUNICATION_SYSTEM, "IT Support"),
    MESSAGING_SYSTEM(WorkCategory.IT_AND_TELECOMMUNICATION_SYSTEM, "Messaging"),

    BANKING(WorkCategory.FINANCE_AND_BANKING,"finance and Banking"),
    INSURANCE(WorkCategory.FINANCE_AND_BANKING, "Insurance"),
    ACCOUNTING(WorkCategory.FINANCE_AND_BANKING, "Accounting"),
    AUDITING(WorkCategory.FINANCE_AND_BANKING, "Auditing"),

    DOCTORS(WorkCategory.HEALTH_CARE,"doctors"),
    NURSES(WorkCategory.HEALTH_CARE,"nurses"),
    PUBLIC_HEALTH(WorkCategory.HEALTH_CARE,"Public Health"),
    PHYSIOTHERAPIST(WorkCategory.HEALTH_CARE,"Physiotherapist"),
    LABORATORY_MEDICINE(WorkCategory.HEALTH_CARE,"Laboratory Medicine"),


    FILM_MAKING(WorkCategory.MEDIA_AND_ENTERTAINMENT,"Film Making"),
    DIRECTOR(WorkCategory.MEDIA_AND_ENTERTAINMENT,"Director"),
    PRODUCER(WorkCategory.MEDIA_AND_ENTERTAINMENT,"Producer"),
    DJ(WorkCategory.MEDIA_AND_ENTERTAINMENT,"DJ"),
    BROADCASTING(WorkCategory.MEDIA_AND_ENTERTAINMENT,"Broadcasting"),
    CONTENT_CREATION(WorkCategory.MEDIA_AND_ENTERTAINMENT,"Content Creation"),

    DRIVER(WorkCategory.DOMESTIC_SERVICES,"driver"),
    MAIDEN(WorkCategory.DOMESTIC_SERVICES,"maiden"),
    GATE_KEEPER(WorkCategory.DOMESTIC_SERVICES,"Gate Keeper"),
    GARDEN_CLEANER(WorkCategory.DOMESTIC_SERVICES,"Garden Cleaner"),
    SALES_GIRL(WorkCategory.DOMESTIC_SERVICES,"Sales Girl"),
    SALES_BOY(WorkCategory.DOMESTIC_SERVICES,"Sales Boy"),
    BAR_ATTENDANT(WorkCategory.DOMESTIC_SERVICES,"Bar Attendant"),
    TEACHER(WorkCategory.DOMESTIC_SERVICES,"Teacher"),

    TRAVELING_BUS(WorkCategory.LOGISTIC_AND_TRANSPORTATION,"Traveling Bus"),
    AIRPLANE_DRIVER(WorkCategory.LOGISTIC_AND_TRANSPORTATION,"Airplane Driver"),
    RIDE_HAILING_SERVICES(WorkCategory.LOGISTIC_AND_TRANSPORTATION,"Ride Hailing"),
    ORDER_DELIVERY_RIDE(WorkCategory.LOGISTIC_AND_TRANSPORTATION,"Order Delivery transport"),


    VISUAL_ART(WorkCategory.ART_AND_CRAFT,"Visual Art"),
    HAND_CRAFTING(WorkCategory.ART_AND_CRAFT,"Hand Crafting"),
    BEAD_MAKING(WorkCategory.ART_AND_CRAFT,"Bead Making"),
    POTTERY(WorkCategory.ART_AND_CRAFT,"Pottery"),
    BASKET_MADE(WorkCategory.ART_AND_CRAFT,"Basket Making"),

    TAILORING(WorkCategory.HAND_WORKMANSHIP,"Tailoring"),
    CARPENTER(WorkCategory.HAND_WORKMANSHIP,"Carpenter"),
    HAIR_STYLIST(WorkCategory.HAND_WORKMANSHIP,"Hair Stylist"),
    ALUMINIUM(WorkCategory.HAND_WORKMANSHIP,"Aluminium"),
    PHONE_ENGINEERING(WorkCategory.HAND_WORKMANSHIP,"Phone Engineering"),
    PLUMBER(WorkCategory.HAND_WORKMANSHIP,"Plumber"),
    WEATHERING(WorkCategory.HAND_WORKMANSHIP,"Weathering"),
    MAKE_UP(WorkCategory.HAND_WORKMANSHIP,"Make Up"),
    BARBER(WorkCategory.HAND_WORKMANSHIP,"Barber"),
    PAINTING(WorkCategory.HAND_WORKMANSHIP,"Painting"),

    MECHANICAL_ENGINEERING(WorkCategory.ENERGY_AND_RENEWABLE_RESOURCES,"mechanical engineering"),
    ELECTRICAL_ENGINEERING(WorkCategory.ENERGY_AND_RENEWABLE_RESOURCES,"electrical engineering"),
    RENEWABLE_ENGINEER(WorkCategory.ENERGY_AND_RENEWABLE_RESOURCES,"renewable engineering"),
    SECONDARY_SOURCE_ENGINEER(WorkCategory.ENERGY_AND_RENEWABLE_RESOURCES,"secondary source engineering"),
    PRIMARY_SOURCE_ENGINEER(WorkCategory.ENERGY_AND_RENEWABLE_RESOURCES,"primary source engineering");



    private final WorkCategory workCategory;
    private final String displayName;


    SubWorkCategory(WorkCategory workCategory, String displayName) {
        this.workCategory = workCategory;
        this.displayName = displayName;
    }





}
