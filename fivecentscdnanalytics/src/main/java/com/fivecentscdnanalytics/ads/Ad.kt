package com.fivecentscdnanalytics.ads

data class Ad(
    var isLinear: Boolean = false,
    var width: Int = 0,
    var height: Int = 0,
    var id: String? = null,
    var mediaFileUrl: String? = null,
    var clickThroughUrl: String? = null,
    var bitrate: Int? = null,
    var minBitrate: Int? = null,
    var maxBitrate: Int? = null,
    var mimeType: String? = null,
    var adSystemName: String? = null,
    var adSystemVersion: String? = null,
    var advertiserName: String? = null,
    var advertiserId: String? = null,
    var apiFramework: String? = null,
    var creativeAdId: String? = null,
    var creativeId: String? = null,
    var universalAdIdRegistry: String? = null,
    var universalAdIdValue: String? = null,
    var description: String? = null,
    var minSuggestedDuration: Long? = null,
    var surveyUrl: String? = null,
    var surveyType: String? = null,
    var title: String? = null,
    var wrapperAdsCount: Int? = null,
    var codec: String? = null,
    var pricingValue: Long? = null,
    var pricingModel: String? = null,
    var pricingCurrency: String? = null,
    var skippableAfter: Long? = null,
    var skippable: Boolean? = null,
    var duration: Long? = null,
    var dealId: String? = null
)