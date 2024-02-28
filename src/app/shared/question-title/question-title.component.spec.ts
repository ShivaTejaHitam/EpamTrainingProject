import { ComponentFixture, TestBed } from '@angular/core/testing';

import { QuestionTitleComponent } from './question-title.component';

describe('QuestionTitleComponent', () => {
  let component: QuestionTitleComponent;
  let fixture: ComponentFixture<QuestionTitleComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ QuestionTitleComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(QuestionTitleComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
