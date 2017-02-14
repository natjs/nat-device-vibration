//
//  NatVibration.m
//
//  Created by huangyake on 17/1/7.
//  Copyright © 2017 Nat. All rights reserved.
//

#import "NatVibration.h"
#import <AVFoundation/AVFoundation.h>  

@interface NatVibration ()
{
    NSTimer *timer;
}

@property(nonatomic, assign)NSInteger time;

@end

@implementation NatVibration


+ (id)singletonManger{
    static id manager = nil;
    static dispatch_once_t onceToken;
    dispatch_once(&onceToken, ^{
        manager = [[self alloc] init];
    });
    return manager;
}


- (void)vibrate:(NSNumber *)time :(NatCallback)callback{
    AudioServicesPlaySystemSound(kSystemSoundID_Vibrate);
}


@end
