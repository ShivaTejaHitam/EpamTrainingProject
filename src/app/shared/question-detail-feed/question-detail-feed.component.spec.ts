import { ComponentFixture, TestBed } from '@angular/core/testing';

import { QuestionDetailFeedComponent } from './question-detail-feed.component';

describe('QuestionDetailFeedComponent', () => {
  let component: QuestionDetailFeedComponent;
  let fixture: ComponentFixture<QuestionDetailFeedComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ QuestionDetailFeedComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(QuestionDetailFeedComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
