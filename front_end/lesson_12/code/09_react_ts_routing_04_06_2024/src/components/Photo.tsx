import { FC } from 'react'
import { IPhotoJson } from './PhotoList'

const Photo: FC<{photo: IPhotoJson}> = ({ photo }) => {
  return (
    <div className="col-3 mb-4">
      <div className="card">
        <img src={photo.thumbnailUrl} className="card-img-top" alt={photo.title} />
        <div className="card-body">
          <h5 className="card-title">{photo.title}</h5>
        </div>
      </div>
    </div>
  )
}

export default Photo