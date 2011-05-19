//
//  Battery.m
//  BatteryStatus
//
//  Created by Andrew Lunny on 11-05-17.
//  Copyright 2011 Nitobi. All rights reserved.
//

#import "Battery.h"


@implementation Battery

-(void) get:(NSMutableArray*)arguments
   withDict:(NSMutableDictionary*)options {
    win = [arguments objectAtIndex:0];
    fail = [arguments objectAtIndex:1];
    NSString* jsString = NULL;
    PluginResult* result = nil;
    
    float rawStatus;
    NSUInteger status;
    
    rawStatus = [[UIDevice currentDevice] batteryLevel];
    if (rawStatus < 0)
        status = 42;
    else
        status = rawStatus * 100.0;
    
    @try {
        result = [PluginResult resultWithStatus:PGCommandStatus_OK
                                messageAsString:[NSString stringWithFormat:@"{\\\"level\\\":%d}", status]];
        jsString = [result toSuccessCallbackString:win];
    }
    @catch (NSException *exception) {
        result = [PluginResult resultWithStatus:PGCommandStatus_ERROR messageAsString:@"error: could not read battery!"];
        jsString = [result toErrorCallbackString:fail];
    }
    @finally {
        NSLog(jsString);
        [[self webView] stringByEvaluatingJavaScriptFromString:jsString];
    }
}

@end
