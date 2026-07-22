import axios from 'axios';
import GitClient from './GitClient';

jest.mock('axios');

describe('Git Client Tests', () => {

    test('should return repository names for techiesyed', () => {
        const repos = { data: [{ name: 'repo1' }, { name: 'repo2' }] };
        axios.get.mockImplementation(() => Promise.resolve(repos));

        return GitClient.getRepositories('techiesyed').then(response => {
            expect(response.data).toEqual(repos.data);
        });
    });

});