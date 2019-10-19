import { TestBed } from '@angular/core/testing';

import { StudentApiService } from './student-api.service';

describe('StudentApiService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: StudentApiService = TestBed.get(StudentApiService);
    expect(service).toBeTruthy();
  });
});
