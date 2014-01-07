//
//  DetailViewController.h
//  storyboard
//
//  Created by wyatt on 9/11/13.
//  Copyright (c) 2013 wyatt. All rights reserved.
//

#import <UIKit/UIKit.h>

@interface DetailViewController : UIViewController

@property (strong, nonatomic) id detailItem;

@property (weak, nonatomic) IBOutlet UILabel *detailDescriptionLabel;
@end
