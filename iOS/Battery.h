//
//  Battery.h
//  BatteryStatus
//
//  Created by Andrew Lunny on 11-05-17.
//  Copyright 2011 Nitobi. All rights reserved.
//

#import <Foundation/Foundation.h>
#ifdef PHONEGAP_FRAMEWORK
#import <PhoneGap/PhoneGapCommand.h>
#else
#import "PhoneGapCommand.h"
#endif

@interface Battery : PhoneGapCommand {
    NSString *win;
    NSString *fail;
}

-(void) get:(NSMutableArray*)arguments
        withDict:(NSMutableDictionary*)options;

@end
