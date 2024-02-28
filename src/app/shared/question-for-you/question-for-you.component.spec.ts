import { ComponentFixture, TestBed } from '@angular/core/testing';

import { QuestionForYouComponent } from './question-for-you.component';

describe('QuestionForYouComponent', () => {
  let component: QuestionForYouComponent;
  let fixture: ComponentFixture<QuestionForYouComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ QuestionForYouComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(QuestionForYouComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
