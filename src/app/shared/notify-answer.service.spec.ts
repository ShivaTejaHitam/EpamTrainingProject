import { TestBed } from '@angular/core/testing';

import { NotifyAnswerService } from './notify-answer.service';

describe('NotifyAnswerService', () => {
  let service: NotifyAnswerService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(NotifyAnswerService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
