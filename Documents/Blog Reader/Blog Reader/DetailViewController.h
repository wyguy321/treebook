//
//  DetailViewController.h
//  Blog Reader
//
//  Created by wyatt on 6/5/13.
//  Copyright (c) 2013 wyatt. All rights reserved.
//

#import <UIKit/UIKit.h>

@interface DetailViewController : UIViewController

@property (strong, nonatomic) id detailItem;

@property (weak, nonatomic) IBOutlet UILabel *detailDescriptionLabel;
@end
