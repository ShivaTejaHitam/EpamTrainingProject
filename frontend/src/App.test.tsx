import React from 'react';
import { render, screen } from '@testing-library/react';
import { MemoryRouter } from 'react-router-dom'; // This is used for routing in testing
import App from './App';

test('renders App component with routes', () => {
  render(
    <MemoryRouter initialEntries={['/']}>
      <App />
    </MemoryRouter>
  );

  // Check if the Home component is rendered when the URL is '/'
  expect(screen.getByText('Home Page')).toBeInTheDocument(); // Replace with actual text/content

  // You can write similar tests for other routes
});

test('renders ErrorPage component when route does not match', () => {
  render(
    <MemoryRouter initialEntries={['/non-existent-route']}>
      <App />
    </MemoryRouter>
  );

  // Check if the ErrorPage component is rendered when the route doesn't match any defined routes
  expect(screen.getByText('Error Page')).toBeInTheDocument(); // Replace with actual text/content
});
