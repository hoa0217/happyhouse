export default interface JoinRs {
  data: number;
  message: string;
  responseCode:
    | 'BAD_REQUEST'
    | 'CONFLICT'
    | 'CREATED'
    | 'DB_ERROR'
    | 'FORBIDDEN'
    | 'INTERNAL_SERVER_ERROR'
    | 'NOT_FOUND'
    | 'NO_CONTENT'
    | 'OK'
    | 'SERVICE_UNAVAILABLE'
    | 'UNAUTHORIZED';
}
