import React from 'react';
import { render, fireEvent, waitFor, screen } from '@testing-library/react';
import Share from './Share'; // Update the import path if necessary
import questionService from '../../services/questionService';

jest.mock('../../services/questionService', () => ({
  postQuestion: jest.fn(),
}));

test('renders Share component', () => {
  render(<Share />);

  const shareComponent = screen.getByTestId('share-component');
  
  expect(shareComponent).toBeInTheDocument();
});

test('handles input change',  () => {
  render(<Share />);
  const inputElement = screen.getByTestId('shareInput') as HTMLInputElement;

  fireEvent.change(inputElement, { target: { value: 'Test question' } });

  expect(inputElement.value).toBe('Test question');

});

/*
test('handles form submission', async () => {
  render(<Share />);
  const inputElement = screen.getByPlaceholderText('Ask a Question');
  const postButton = screen.getByText('Post Question');

  fireEvent.change(inputElement, { target: { value: 'Test question' } });
  fireEvent.click(postButton);

  // Assuming that your questionService.postQuestion function returns a promise
  await waitFor(() => {
    expect(questionService.postQuestion).toHaveBeenCalledWith('', {
      questionContent: 'Test question',
      userEmail: 'shivateja.bandaru@gmail.com',
    });
  });

  expect(inputElement.textContent).toBe('');
});
*/