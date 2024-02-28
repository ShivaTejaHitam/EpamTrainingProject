import { TestBed } from '@angular/core/testing';

import { NotifyPostService } from './notify-post.service';

describe('NotifyPostService', () => {
  let service: NotifyPostService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(NotifyPostService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
