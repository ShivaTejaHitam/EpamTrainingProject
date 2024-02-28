import { AppRoutingModule } from './app-routing.module';
import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { ReactiveFormsModule } from '@angular/forms';

import { AppComponent } from './app.component';
import { FeedComponent } from './shared/feed/feed.component';
import { QuestionsService } from './shared/questions.service';
import { HttpClientModule } from '@angular/common/http';
import { RightbarComponent } from './shared/rightbar/rightbar.component';
import { LeftbarComponent } from './shared/leftbar/leftbar.component';
import { TopbarComponent } from './shared/topbar/topbar.component';
import { PostComponent } from './shared/post/post.component';
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MatIconModule } from '@angular/material/icon';
import { ShareComponent } from './shared/share/share.component';
import { SpaceComponent } from './shared/space/space.component';
import { QuestionForYouComponent } from './shared/question-for-you/question-for-you.component';
import { QuestionDetailsComponent } from './question-details/question-details.component';
import { ErrorPageComponent } from './error-page/error-page.component';
import { QuestionDetailFeedComponent } from './shared/question-detail-feed/question-detail-feed.component';
import { QuestionTitleComponent } from './shared/question-title/question-title.component';
import { ModalComponent } from './shared/modal/modal.component';
import { CommentsComponent } from './shared/comments/comments.component';

@NgModule({
  declarations: [
    AppComponent,
    FeedComponent,
    RightbarComponent,
    LeftbarComponent,
    TopbarComponent,
    PostComponent,
    HomeComponent,
    LoginComponent,
    RegisterComponent,
    ShareComponent,
    SpaceComponent,
    QuestionForYouComponent,
    QuestionDetailsComponent,
    ErrorPageComponent,
    QuestionDetailFeedComponent,
    QuestionTitleComponent,
    ModalComponent,
    CommentsComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    BrowserAnimationsModule,
    ReactiveFormsModule,
    MatIconModule,
  ],
  providers: [QuestionsService],
  bootstrap: [AppComponent]
})
export class AppModule { }
